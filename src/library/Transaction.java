package library;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Transaction implements Serializable {
    private static final long SUID = 1L;

    private String bISBN;  
    private String uID;    
    private Date issDt;    
    private Date retDt;    
    private double fineAmt;

    
    public Transaction(String bISBN, String uID) {
        this.bISBN = bISBN;
        this.uID = uID;
        this.issDt = new Date();
        this.retDt = null;
        this.fineAmt = 0.0;
    }
    public String getBISBN() { return bISBN; }
    public String getUID() { return uID; }
    public Date getIssDt() { return issDt; }
    public Date getRetDt() { return retDt; }
    public double getFineAmt() { return fineAmt; }
    public void retBk() {
        this.retDt = new Date();
        this.calcFn();
    }
    private void calcFn() {
        if (retDt == null || issDt == null) return;

        long diffInMillies = Math.abs(retDt.getTime() - issDt.getTime());
        long diffDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        int freeDays = 7;
        if (diffDays > freeDays) {
            this.fineAmt = (diffDays - freeDays) * 10.0;
        } else {
            this.fineAmt = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Trans[User=" + uID + ", Book=" + bISBN + ", Issued=" + issDt + ", Fine=" + fineAmt + "]";
    }
}
