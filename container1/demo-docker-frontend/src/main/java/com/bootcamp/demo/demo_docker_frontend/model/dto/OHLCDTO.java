package com.bootcamp.demo.demo_docker_frontend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OHLCDTO {
  private Chart chart;

  @Getter
  @ToString
  public static class Chart {

    @JsonProperty("result")
    private Result[] results;
    private Object error; // type tbc

    @Getter
    @ToString
    public static class Result {
      private Meta meta;
      @JsonProperty("timestamp")
      private Long[] timestamps;
      @JsonProperty("indicators")
      private Indicator indicator;

      @Getter
      @ToString
      public static class Meta {
        private String currency;
        private String symbol;
        private String exchangeName;
        private String fullExchangeName;
        private String instrumentType;
        private Long firstTradeDate;
        private Long regularMarketTime;
        private Boolean hasPrePostMarketData;
        private Integer gmtoffset;
        private String timezone;
        private String exchangeTimezoneName;
        private Double regularMarketPrice;
        private Double fiftyTwoWeekHigh;
        private Double fiftyTwoWeekLow;
        private Double regularMarketDayHigh;
        private Double regularMarketDayLow;
        private Double regularMarketVolume;
        private Double chartPreviousClose;
        private Double priceHint;
        private CurrentTradingPeriod currentTradingPeriod;
        private String dataGranularity;
        private String range;
        private String[] validRanges;

        @Getter
        @ToString
        public static class CurrentTradingPeriod {
          private Period pre;
          private Period regular;
          private Period post;

          @Getter
          @ToString
          public static class Period {
            private String timezone;
            private Long start;
            private Long end;
            private Integer gmtoffset;
          }
        }
      }

      @Getter
      @ToString
      public static class Indicator {
        @JsonProperty(value = "quote")
        private Quote[] quotes;

        @Getter
        @ToString
        public static class Quote {
          @JsonProperty(value = "volume")
          private Long[] volumes;
          @JsonProperty(value = "close")
          private Double[] closes;
          @JsonProperty(value = "high")
          private Double[] highs;
          @JsonProperty(value = "low")
          private Double[] lows;
          @JsonProperty(value = "open")
          private Double[] opens;
        }
      }
    }
  }
}
