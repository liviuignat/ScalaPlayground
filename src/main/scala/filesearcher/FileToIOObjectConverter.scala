package filesearcher

import java.io.File

/**
 * Created by liviu.ignat on 3/10/2015.
 */
object FileToIOObjectConverter {
  def convertToIOObject(file: File): IOObject = {
    if(file isDirectory()) DirectoryObject(file)
    else FileObject(file)
  }
}
