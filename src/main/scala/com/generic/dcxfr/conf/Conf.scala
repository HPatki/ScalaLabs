package com.generic.dcxfr.conf

import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext, sql}

class Conf (appname:String)
{
    //val session = sql.SparkSession.builder().enableHiveSupport().appName(appname).getOrCreate()
    private val m_sparkConf = new SparkConf().setAppName(appname)
    private var m_sparkContext : SparkContext = null
    private var m_BasePath : String = null

    def init () : Unit =
    {
        m_sparkContext = new SparkContext(m_sparkConf)
        m_BasePath = "file:///Users/shwetapatki/Documents/data/dctransfer/"
        //m_BasePath = "/user/shwetapatki/dctransfer/"
    }

    def getSparkContext () : SparkContext = m_sparkContext

    def getBasePath () : String = m_BasePath

}
