package multipletraits

/**
 * Created by liviuignat on 11/03/15.
 */
class Man extends Person with Cloneable with Resetable {
  override def age: Int = 1

  override def reset: Unit = ???
}
