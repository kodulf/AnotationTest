package dbannotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static  void main(String[] args) throws Exception {
        //千万要注意这里的参数是要带上package的目录的
        String[] args2 = {"dbannotation.Member"};

        for(String className : args2){
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);

            if(dbTable == null){
                System.out.println("No DBTable annotations in class "+ className);
                continue;
            }

            String tableName = dbTable.name();

            //if name is empty, use the Class Name;
            if(tableName.length()<1)
                tableName = cl.getName().toUpperCase();
            List<String> columnDefs = new ArrayList<>();
            for (Field field: cl.getDeclaredFields()){
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if(anns.length<1){
                    continue;//Not a db table column
                }

                if(anns[0] instanceof SQLInteger){
                    SQLInteger sInt = (SQLInteger) anns[0];
                    //Use field name if name not specified
                    if(sInt.name().length()<1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sInt.name();

                    columnDefs.add(columnName + " INT"+
                            getConstraints(sInt.constrains()));

                }

                if(anns[0] instanceof SQLString){
                    SQLString sString = (SQLString) anns[0];
                    //Use field name if name not specified
                    if(sString.name().length()<1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();

                   columnDefs.add(columnName+" VARCHAR("+sString.value()+" )"+
                           getConstraints(sString.constrains()));
                }
            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE "+tableName +"(");

            for (String columnDef :columnDefs){
                createCommand.append("\n     "+columnDef +",");
                //Remove trailing comma
                String tableCreate= createCommand.substring(0,createCommand.length()-1) + ");";
                //输出
                System.out.println("Table Creation SQL for "+className + " is :\n"+tableCreate);
            }

        }
    }

    private static String getConstraints(Constrains con) {

        String constrains = "";
        if(!con.allowNull())
            constrains +=" NOT NULL";
        if(con.primaryKey())
            constrains +=" PRIMARY KEY";
        if(con.unique())
            constrains +=" UNIQUE";

        return constrains;

    }

}
