import org.graphstream.graph.{Edge, Node}
import org.graphstream.graph.implementations.{MultiGraph, SingleGraph, SingleNode}
import scala.io.Source


/*
 * CS3210 - Principles of Programming Languages - Fall 2021
 * Instructor: Thyago Mota
 * Student:
 * Description: Homework 01 - PLGraph
 */

object PLGraphOriginal {

  val PL_CSV_FILE = "pl.csv"
  val USER_DIR    = System.getProperty("user.dir")
  val STYLE       = "stylesheet.css"

  def main(args: Array[String]): Unit = {

    // create the graph
    val graph = new MultiGraph("PL")
//    graph.addAttribute("ui.stylesheet", "url('file://" + USER_DIR + "/" + STYLE + "')")
    graph.addAttribute("ui.stylesheet", "url(stylesheet.css)")
    graph.addAttribute("ui.antialias")

    // TODO: parse the PL_CSV_FILE to create a directed graph of PLs
    var reader = Source.fromFile(PL_CSV_FILE)
    for(line <- reader.getLines()){
      println(line)
    }
    reader.close()

    // display the graph
    graph.display()
  }
}

//Helpful resource: https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/