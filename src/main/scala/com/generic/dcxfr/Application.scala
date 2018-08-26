package com.generic.dcxfr

import com.generic.dcxfr.conf.Conf
import com.generic.dcxfr.data.LoadData

import scala.collection.mutable.ListBuffer

object Application
{
    private var m_conf : Conf = null
    private var m_BasePath : String = null

    def main (args:Array[String]): Unit =
    {
        m_conf = new Conf("DC Transfers")
        m_conf.init()

        val LoadObject = new LoadData ()
        LoadObject.process()
    }

    def getContext() : Conf = m_conf
}
