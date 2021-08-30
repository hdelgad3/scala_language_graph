import org.graphstream.graph.{Edge, Node}
import org.graphstream.graph.implementations.{MultiGraph, SingleGraph, SingleNode}
import scala.io.Source
import scala.collection.mutable.ArrayBuffer


/*
 * CS3210 - Principles of Programming Languages - Fall 2021
 * Instructor: Thyago Mota
 * Student:     Hector Delgado
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
    val arr = ArrayBuffer[String]()

//    Read lines from file and then append line to bufferArray
    for(line <- reader.getLines()){
      arr.append(line)
    }
    reader.close()

//    Send the line to the node creator
    for(index <- 0 until arr.length){
      addNode(graph, arr(index))
//      println(arr(index))
//      println(arr(index).getClass())
    }

    // display the graph
    graph.display()
  }


  def addNode(aGraph: MultiGraph, str: String): Unit ={
    var items = str.split(",")
//    println(items(0) + " ,,,,,, " + items(1))
    var firLang = items(0)
    var secLang = items(1)
    if(aGraph.getNode(s"$firLang") == null){
      var node1: Node = aGraph.addNode(s"$firLang")
      node1.addAttribute("ui.label", s"$firLang")
    }
    if(aGraph.getNode(s"$secLang") == null){
      var node2: Node = aGraph.addNode(s"$secLang")
      node2.addAttribute("ui.label", s"$secLang")
    }

    var edge: Edge = aGraph.addEdge(s"$firLang$secLang", s"$firLang", s"$secLang", true)

  }
}

//Helpful resource: https://alvinalexander.com/scala/how-to-open-read-text-files-in-scala-cookbook-examples/