package eu.wdaqua.nell2rdf.extract.metadata.models;

import eu.wdaqua.nell2rdf.extract.metadata.util.Utility;
import static eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList.*;

/**
 *
 * @author Maisa
 */public class SpreadsheetEdits extends Header {

    private String userFeedback;
    private String entity;
    private String relation;
    private String value;
    private String action;
    private String fromIteration;

    public SpreadsheetEdits(String str, Double Probability) {
        super(str, SPREADSHEETEDITS, Probability);
    }

    public String getMetadata_UserFeedback() {
        return userFeedback;
    }

    public String getMetadata_Entity() {
        return entity;
    }

    public String getMetadata_Relation() {
        return relation;
    }

    public String getMetadata_Value() {
        return value;
    }

    public String getMetadata_Action() {
        return action;
    }

    public String getMetadata_From() {
        return fromIteration;
    }

    @Override
    public void processStringText(String str) {
        this.userFeedback = Utility.getSpreadSheetUserFeedback(str);
        this.action = Utility.getSpreadSheetAction(str);
        this.fromIteration = Utility.getSpreadSheetFrom(str);

        if (this.userFeedback != null) {
            String tempSplit[] = Utility.getSpreadSheetERV(str, this.userFeedback).split(" ");
            try {
                this.entity = tempSplit[0];
                this.relation = tempSplit[1];
                this.value = tempSplit[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e + "\nprocessStringText + SpreadSheetEdits\n" + str);
            }
        } else {
            String tempSplit[] = Utility.getSpreadSheetERV_NULL_USER(str).split(" ");
            try {
                this.entity = tempSplit[0].substring(tempSplit[0].lastIndexOf(":") + 1);
                this.relation = tempSplit[1].substring(tempSplit[1].lastIndexOf(":") + 1);
                this.value = tempSplit[2].substring(tempSplit[2].lastIndexOf(":") + 1);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e + "\nprocessStringText + SpreadSheetEdits\n" + str);
            }
        }

    }

    @Override
    public String toString() {
        StringBuffer temp = new StringBuffer();
        temp.append(" (").append(this.entity).append(",").append(this.relation).append(",").append(this.value).append(")");
        temp.append("-").append(this.userFeedback).append("-");
        temp.append(" FROM: ").append(this.fromIteration);
        temp.append(" ACTION: ").append(this.action);

        return super.toString() + temp.toString() + "}";
    }

    @Override
    public String getStringSource() {
        StringBuffer temp = new StringBuffer();
        temp.append(" (").append(this.entity).append(",").append(this.relation).append(",").append(this.value).append(")");
        temp.append("-").append(this.userFeedback).append("-");
        temp.append(" FROM: ").append(this.fromIteration);
        temp.append(" ACTION: ").append(this.action);
        return temp.toString() + "}";
    }
}
  
