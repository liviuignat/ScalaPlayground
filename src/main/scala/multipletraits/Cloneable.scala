package multipletraits

/**
 * Created by liviuignat on 11/03/15.
 */
trait   Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}


