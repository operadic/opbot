/* Some imports to help us do some category-theoretic reasoning */
import cats._
import cats.implicits._


/* The folowing is a finally tagless encoding of a tree-like data structure which is closed under evaluation. */
trait Tree[F[_]]{
    def leaf[A](a: A): F[A]
    def node[A,B](fa: F[A])(fb: F[B]): F[(A,B)]
    def eval[G[_]: Tree, A,B,C](fab: F[(A,B)])(g: (A,B) => G[C]): G[C]
}

object Tree {
    def apply[F[_]:Tree]: Tree[F] = implicitly //this is just boilerplate for syntax purposes below
}

def tfold[F[_] : Tree, G[_]: Tree,A,B,C](node: F[(A,B)])(g: (A,B) => G[C]): G[C] = Tree[F].eval(node)(g)