/**
 * Playing with the bitcoin-s library which provides Scala implementations of various native Bitcoin and Lightning primitive data structures.
 * Additionally, the library provides a typed interface wrapping Bitcoin Core's bitcoind daemon and Acinq's eclair lightning node.
 */

/**
 * First, let's setup an abstract console and logger which can be used to ask the user for input, display output, and log progress.
 * */

 import cats._
 import cats.implicits._

 import scala.util.Try

 trait Console[F[_]]{
     def print[A: Show](a: A): F[Unit]
     def readLine: F[String]
 }
 object Console {
     def apply[F[_]:Console]:Console[F] = implicitly

     // a trivial blocking interpreter
     implicit val consoleId = new Console[Id] {
        def print[A : Show](a: A): Id[Unit] = println(a.show)
        def readLine: Id[String] = scala.io.StdIn.readLine()
     } 
 }
 
 // a helper program useful for prompting the user for something repeatedly until successful
 def promptUntilSuccess[F[_]: Console : Monad,A](prompt: String, validator: String => Either[Throwable,A], successMessage: String): F[A] = for {
    _ <- Console[F].print(prompt)
    input <- Console[F].readLine
    output <- validator(input) match { 
        case Right(m) => Console[F].print(successMessage) *> Monad[F].pure(m); 
        case Left(e) => Console[F].print(e.getMessage) *> promptUntilSuccess(prompt,validator,successMessage)
    }
 } yield output

 // following the tutorial here: https://bitcoin-s.org/docs/core/core-intro
 import org.bitcoins.core.protocol.transaction._

 def loadTransactionFromHex[F[_]: Console : Monad]: F[Transaction] = 
    promptUntilSuccess("Enter a Hex string and we will convert it to a transaction",
                        s => Try(Transaction.fromHex(s)).toEither,
                        "Success!")

