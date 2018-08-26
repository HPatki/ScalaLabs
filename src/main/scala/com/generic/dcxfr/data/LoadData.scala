package com.generic.dcxfr.data

import org.apache.spark.rdd
import com.generic.dcxfr.conf.Conf
import com.generic.dcxfr.Application

class LoadData {

  def process () : Unit =
  {
      prepare()
  }

  def LambdaFunc[u] (func:=>u) : Unit =
  {

  }

  private def prepare () : Unit =
  {
      val sc = Application getContext() getSparkContext()
      val ccmap = sc.textFile((Application getContext() getBasePath())+ "ccmap.csv" )
      val ccList = ccmap.map (x=>{ val rec = x.split(","); rec(0) })

      //val arrCCList = ccList map (line=>line.split(',') ) first
      //val transformedCCList = sc.parallelize(arrCCList)

      val storeDCMap = sc.textFile((Application getContext() getBasePath())+ "storeDCmap.csv")
      val dcstorecount = sc.textFile((Application getContext() getBasePath())+ "dcStoreCount.csv")
      val ccdcstorecount = dcstorecount.map (rec => { val splitrec = rec.split(",")
      splitrec(0).slice(0,9) + "," + splitrec(0).substring(9) + "," + splitrec(1)})

      val ccDCStores = ccList.cartesian(ccdcstorecount).filter(rec => rec._1 == rec._2.substring(0,9)) repartition(1)

      ccDCStores.saveAsTextFile("file:///Users/shwetapatki/Documents/data/dctransfer/runoutput")
      val incomingPO = sc.textFile((Application getContext() getBasePath())+ "incPO.csv")

  }

}
