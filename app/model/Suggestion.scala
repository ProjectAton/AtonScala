package model

/**
  * POJO with the basic Suggestion information (Used by the Suggestion DAO, Service and Controller)
  */
case class Suggestion(
                       id: Long,
                       suggestion: String,
                       registeredDate: java.sql.Timestamp
                     )
