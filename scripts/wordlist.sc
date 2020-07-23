// Build a word list for a corpus
import edu.holycross.shot.ohco2._
import edu.holycross.shot.mid.orthography._
import edu.holycross.shot.latin._

import java.io.PrintWriter

val urls : Map[String, String] = Map(
  "hyginus" -> "https://raw.githubusercontent.com/LinguaLatina/texts/master/texts/latin23/hyginus.cex",
  "pliny" -> "https://raw.githubusercontent.com/LinguaLatina/texts/master/texts/latin24/pliny-letters.cex"
)

val orthos: Map[String, MidOrthography] = Map(
  "hyginus" -> Latin23Alphabet,
  "pliny" -> Latin24Alphabet,

)

def tokenizable(corpusLabel: String) : TokenizableCorpus = {
  val url = urls(corpusLabel)
  val ortho = orthos(corpusLabel)
  val corpus = CorpusSource.fromUrl(url, cexHeader = true)
  TokenizableCorpus(corpus, ortho)
}


def usage: Unit = {
  
}
