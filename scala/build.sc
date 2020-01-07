import mill._, scalalib._

object opbotcore extends ScalaModule {
  def scalaVersion = "2.12.4"

  val bitcoinSversion = "0.2.0"
  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:2.0.0",
    //ivy"org.bitcoin-s::bitcoin-s-secp256k1jni:${bitcoinSversion}",
    ivy"org.bitcoin-s::bitcoin-s-core:${bitcoinSversion}",
    ivy"org.bitcoin-s::bitcoin-s-bitcoind-rpc:${bitcoinSversion}",
    ivy"org.bitcoin-s::bitcoin-s-eclair-rpc:${bitcoinSversion}"
  )
}
