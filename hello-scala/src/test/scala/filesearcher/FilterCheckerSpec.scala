package filesearcher

import java.io.File

import org.scalatest.FlatSpec


/**
 * Created by liviu.ignat on 3/10/2015.
 */
class FilterCheckerSpec extends FlatSpec {
  "When passed a list to the filter and a file matches" should
  "return a list with that file" in {
    val listOfFiles = List(new FileObject(new File("random")), new FileObject(new File("match")))
    val matchedFiles = FilterChecker("match") findMatchedFiles(listOfFiles)
    assert(matchedFiles == List(new FileObject(new File("match"))))
  }

  "When passed a list with a directory in it" should
  "never return the directory from it" in {
    val listOfIOObjects = List(FileObject(new File("file")), DirectoryObject(new File("dir")))
    val matchedFiles = FilterChecker("dir") findMatchedFiles(listOfIOObjects)
    assert(matchedFiles.length == 0)
  }
}
