package models

/**
  * Created by dominik on 9/11/16.
  */
import sorm._

object DB extends Instance(entities = Seq(Entity[Campaign]()), url = "jdbc:h2:mem:test" )
