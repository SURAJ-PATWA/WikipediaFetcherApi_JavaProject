package tech.codingclub.database;

import tech.codingclub.entity.Coders;

public class TestCodersTable {

    public static void main(String[] args) {

        Coders coder = new Coders("Arti_Patwa", 21L );

        //Insert this object into DB !

      //           < ENTITY CLASS>
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS,coder);

        Coders spammer = new Coders("SPAMMER", 50L );
        new GenericDB<Coders>().addRow(tech.codingclub.tables.Coders.CODERS,spammer);

    }
}
