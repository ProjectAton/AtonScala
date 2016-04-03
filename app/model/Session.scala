package model

/**
  * POJO with the basic Session information (Used by the Session DAO, Service and Controller)
  */
case class Session(
                    computerIp: String,
                    connectionTime: java.sql.Timestamp,
                    connectedUser: String,
                    active: Boolean
                  )
