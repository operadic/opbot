import mill._, scalalib._

object opbotcore extends ScalaModule {
  def scalaVersion = "2.12.10"

  def ivyDeps = Agg(
    ivy"org.typelevel::cats-core:2.0.0"
  )
}
