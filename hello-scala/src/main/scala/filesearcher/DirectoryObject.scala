package filesearcher
import java.io.File

/**
 * Created by liviu.ignat on 3/10/2015.
 */
case class DirectoryObject(val file: File) extends IOObject {
  def children():  List[IOObject] = {
    file.listFiles()
      .map(file => FileToIOObjectConverter convertToIOObject(file)).toList
  }
}

