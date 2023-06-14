package rest.assured;

public class TickersData {

    private String symbol;
    private String symbolName;
    private String buy;
    private String sell;
    private String changeRate;
    private String changePrice;

    /*
        "ticker":[
        {
            "symbol": "BTC-USDT",   // symbol
            "symbolName":"BTC-USDT", // Name of trading pairs, it would change after renaming
            "buy": "11328.9",   // bestAsk
            "sell": "11329",    // bestBid
            "changeRate": "-0.0055",    // 24h change rate
            "changePrice": "-63.6", // 24h change price
            "high": "11610",    // 24h highest price
            "low": "11200", // 24h lowest price
            "vol": "2282.70993217", // 24h volume，the aggregated trading volume in BTC
            "volValue": "25984946.157790431",   // 24h total, the trading volume in quote currency of last 24 hours
            "last": "11328.9",  // last price
            "averagePrice": "11360.66065903",   // 24h average transaction price yesterday
            "takerFeeRate": "0.001",    // Basic Taker Fee
            "makerFeeRate": "0.001",    // Basic Maker Fee
            "takerCoefficient": "1",    // Taker Fee Coefficient
            "makerCoefficient": "1" // Maker Fee Coefficient
        }
    ]
     */

    public TickersData() {
    }

    public TickersData(String symbol, String symbolName, String buy, String sell, String changeRate, String changePrice) {
        this.symbol = symbol;
        this.symbolName = symbolName;
        this.buy = buy;
        this.sell = sell;
        this.changeRate = changeRate;
        this.changePrice = changePrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getChangeRate() {
        return changeRate;
    }

    public void setChangeRate(String changeRate) {
        this.changeRate = changeRate;
    }

    public String getChangePrice() {
        return changePrice;
    }

    public void setChangePrice(String changePrice) {
        this.changePrice = changePrice;
    }
}
