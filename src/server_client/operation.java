package server_client;
import java.io.Serializable;
public class operation implements Serializable {
	  private int nb1;
	    private int nb2;
	    private char op;
	    private int res;

	    public operation(int nb1, int nb2, char op){
	        this.nb1 = nb1;
	        this.nb2 = nb2;
	        this.op = op;
	    }

	    public int getNb1(){
	        return nb1;
	    }

	    public int getNb2(){
	        return nb2;
	    }

	    public char getOp(){
	        return op;
	    }

	    public void setRes(int res){
	        this.res = res;
	    }

	    public int getRes(){
	        return res;
	    }
}
