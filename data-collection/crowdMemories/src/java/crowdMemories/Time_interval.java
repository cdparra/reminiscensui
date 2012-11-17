/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crowdMemories;

/**
 *
 * @author francesco
 */
class Time_interval {
    
    private String time_interval_id;
    private boolean is_fuzzy;
    private Fuzzy_date fuzzy_startdate;

    public String getTime_interval_id() {
        return time_interval_id;
    }

    public void setTime_interval_id(String time_interval_id) {
        this.time_interval_id = time_interval_id;
    }

    public boolean isIs_fuzzy() {
        return is_fuzzy;
    }

    public void setIs_fuzzy(boolean is_fuzzy) {
        this.is_fuzzy = is_fuzzy;
    }

    public Fuzzy_date getFuzzy_startdate() {
        return fuzzy_startdate;
    }

    public void setFuzzy_startdate(Fuzzy_date fuzzy_startdate) {
        this.fuzzy_startdate = fuzzy_startdate;
    }   
    
}
