package rest.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class CurrencyRate {

    @JsonProperty("ccy")
//    розмоментувати анотацію для Gson і закемонтувати анатацію для Jackson
//    @SerializedName("ccy")
    private String from;

    @JsonProperty("base_ccy")
//    розмоментувати анотацію для Gson і закемонтувати анатацію для Jackson
//    @SerializedName("base_ccy")
    private String to;

    @JsonProperty("buy")
    private BigDecimal buy;

    @JsonProperty("sale")
    private BigDecimal sale;

    public CurrencyRate() {
    }

    public CurrencyRate(String from, String to, BigDecimal buy, BigDecimal sale) {
        this.from = from;
        this.to = to;
        this.buy = buy;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "CurrencyRate{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }
}
