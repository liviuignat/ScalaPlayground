package filesearcher

import java.io.File

/**
 * Created by liviu.ignat on 3/10/2015.
 */
trait IOObject {
  val file: File
  val name = file.getName
}
