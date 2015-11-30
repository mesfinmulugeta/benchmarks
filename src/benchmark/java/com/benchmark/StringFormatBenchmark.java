package com.benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;

@Fork( value = 1 )
public class StringFormatBenchmark
{
  private static final String STR_1 = "str_1 ";
  private static final String STR_2 = " str_2";
  private static final String STR_3 = "str_1 %d str_2";
  private static final int num = 100;

  @Benchmark
  public void concatenate()
  {
    String conc = STR_1 + num + STR_2;
  }

  @Benchmark
  public void stringFormat()
  {
    String sf = String.format( STR_3, num );
  }

  @Benchmark
  public void stringBuilder()
  {
    StringBuilder sb = new StringBuilder();
    sb.append( STR_1 ).append( num ).append( STR_2 );
    String strb = sb.toString();
  }
}