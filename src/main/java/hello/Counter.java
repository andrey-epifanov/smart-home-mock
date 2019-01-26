package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Counter {

    @JsonProperty("Spisok")
    private ArrayList<Roset> list = new ArrayList<>();

    public ArrayList<Roset> getList() {
        return list;
    }

    public void setList(ArrayList<Roset> list) {
        this.list = list;
    }

    @JsonProperty("Period")
    private int period;

    @JsonProperty("Value")
    private int value;

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Counter(){}

    public Counter(int period, int value) {
        this.period = period;
        this.value = value;
    }

    @Override
    public String toString(){
        return "Counter[ Period" + period + ", Value: " + value + ", List: " + list + "]";
    }
}
