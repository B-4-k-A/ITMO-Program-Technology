/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2004-8 LearningPatterns Inc.
 */

package com.javatunes.util;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;

public class ItemDAO
{
   // connection to the database (assumed to be open)
   private Connection m_conn = null;
   
   //// PreparedStatement Lab ////
   //-- declare the PreparedStatement for searchByKeyword --//
   
   
   //// Update Lab ////
   //-- declare the PreparedStatement for create --//
   
   
   
   // constructor
   public ItemDAO(Connection conn)
   throws SQLException
   {
      // store the connection
      m_conn = conn;
      
      //// PreparedStatement Lab ////
      //-- define the ?-SQL for searchByKeyword --//
      
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      
      
      //// Update Lab ////
      //-- define the ?-SQL for create --//
      
      
      //-- prepare the ?-SQL with the DBMS and initialize the PreparedStatement --//
      
   }
   
   
   //// DAO Lab ////
   public MusicItem searchById(Long id)
   throws SQLException
   {
      // declare return value
      MusicItem result = null;
      
      // declare JDBC objects
      Statement stmt = null;
      
      //-- build the SQL statement --//
      String sql = "select * from GUEST.Item where item_id=" + id;


      try
      {
         //-- initialize the Statement object --//
         stmt = m_conn.createStatement();

         //-- execute the SQL statement, get a ResultSet back --//
         ResultSet rs =  stmt.executeQuery(sql);

         
         //-- if ID found, extract data from the ResultSet and initialize the ItemValue return value --//
         if(rs.next()) {
            String title = rs.getString(2);
            String artist = rs.getString(3);
            Date releaseDate = rs.getDate(4);
            BigDecimal listPrice = rs.getBigDecimal(5);
            BigDecimal price = rs.getBigDecimal(6);
            result = new MusicItem(id, title, artist, releaseDate, listPrice, price);
         }
         //-- if ID not found, the return value remains null --//
         
      }
      finally
      {
         //-- close the Statement - this closes its ResultSet --//
         stmt.close();
      }
      
      // return the value object
      return result;
   }
   
   
   //// PreparedStaement Lab ////
   public Collection<MusicItem> searchByKeyword(String keyword)
   throws SQLException
   {
      // create storage for the results
      Collection<MusicItem> result = new ArrayList<>();

      // create the %keyword% wildcard syntax used in SQL LIKE operator
      String wildcarded = "%" + keyword + "%";
      String sql = "select * from GUEST.Item where TITLE like ?";
      
      //-- set the ? parameters on the PreparedStatement --//
      var pstmt = m_conn.prepareStatement(sql);
      pstmt.setString(1, wildcarded);
      
      //-- execute the PreparedStatement, get a ResultSet back --//
      ResultSet rs = pstmt.executeQuery();
      while(rs.next()) {
         long id = rs.getLong(1);
         String title = rs.getString(2);
         String artist = rs.getString(3);
         Date releaseDate = rs.getDate(4);
         BigDecimal listPrice = rs.getBigDecimal(5);
         BigDecimal price = rs.getBigDecimal(6);
         result.add(new MusicItem(id, title, artist, releaseDate, listPrice, price));
      }
      
      
      //-- iterate through the ResultSet, extracting data from each row and creating an ItemValue from it --//
      //-- add the ItemValue to the Collection via Collection's add method --//
      
      
      // return the Collection
      return result;
   }
   
   
   //// Update Lab ////
   public void create(MusicItem item)
   throws SQLException
   {
      String sql = "insert into GUEST.Item (TITLE, ARTIST, RELEASEDATE, LISTPRICE, PRICE, VERSION) VALUES(?, ?, ?, ?, ?, ?)";
	  // Use the following releaseDate value in the  prepared statement for setDate
	  Date releaseDate = new Date(item.getReleaseDate().getTime());
      //-- set the ? parameters on the PreparedStatement --//
      var pstmt = m_conn.prepareStatement(sql);
      pstmt.setString(1, item.getTitle());
      pstmt.setString(2, item.getArtist());
      pstmt.setDate(3, releaseDate);
      pstmt.setBigDecimal(4, item.getListPrice());
      pstmt.setBigDecimal(5, item.getPrice());
      pstmt.setInt(6, 1);
      
      //-- execute the PreparedStatement - ignore the update count --//
      System.out.println("Inserted " + pstmt.executeUpdate() + " rows");
   }
   
   
   //// PreparedStatement and Update Labs ////
   public void close()
   {
      /*
      REMOVE this comment in PreparedStatement Lab
      try
      {
         //// PreparedStatement Lab ////
         //-- close the PreparedStatement for searchByKeyword --//
         
         
         //// Update Lab ////
         //-- close the PreparedStatement for create --//
         
      }
      catch (SQLException sqle)
      {
         JDBCUtilities.printSQLException(sqle);
      }
      REMOVE this comment in the PreparedStatement Lab
      */
   }
}
