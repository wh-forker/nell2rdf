/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.wdaqua.nell2rdf.extract.metadata.models;

import eu.wdaqua.nell2rdf.extract.metadata.util.Utility;

import static eu.wdaqua.nell2rdf.extract.metadata.util.ConstantList.*;

/**
 *
 * @author Maisa
 */
public class KbManipulation extends Header {

    private String oldBug;

    public KbManipulation(String str, Double Probability) {
        super(str, KBMANIPULATION, Probability);
        //System.out.println(LineInstanceJOIN.completeLine);
    }

    public String getMetadata_oldBug() {
        return oldBug;
    }

    @Override
    public void processStringText(String str) {
        oldBug = Utility.getOldBug(str);
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.oldBug + "]";
    }

    @Override
    public String getStringSource() {
        return this.oldBug;
    }
}
