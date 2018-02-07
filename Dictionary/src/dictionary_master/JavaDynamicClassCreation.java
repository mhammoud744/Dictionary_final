package dictionary_master;

import dictionary_master.MyField;
import static javax.tools.JavaFileObject.Kind.SOURCE;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.tools.SimpleJavaFileObject;

/**
 * created By the errors
 */
public class JavaDynamicClassCreation {

    private String className;
    private String inhClass;
    private ArrayList<MyField> fields;

    public JavaDynamicClassCreation() {
        this.className = "Hello";
        this.fields = new ArrayList();
    }

    public JavaDynamicClassCreation(String className, ArrayList<MyField> fields, String inhClass) {
        this.className = className;
        this.fields = fields;
        this.inhClass = inhClass;
    }

    public void dynamicClassCreation() throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException {
        final String path = "./src/dictionary_master";
        final String fullClassName = path + "/" + className;
        String constructor = "public " + className + "(";
        String constructorBody = "{\n\n";
        String costructorArguments = "";

        StringBuilder source = new StringBuilder();
        source.append("package dictionary_master;\n\n");
        //**************//
        if (!inhClass.equals("None")) {
            String superArguments = "";
            ClassLoader parentClassLoader = new ClassLoader(inhClass);
            Field[] parentConstructorArgumets = parentClassLoader.getAllFields();
            for (Field f : parentConstructorArgumets) {
                superArguments += f.getName() + ",";
                costructorArguments += f.getType() + " " + f.getName() + ",";
            }
            superArguments += "";
            source.append("public class " + className + " extends " + inhClass + " implements Comparable<" + ClassLoader.getTheGrandParentName(parentClassLoader.getLoadedClass()) + ">{\n\n"); // badna nzeed extends lal class in choiceBox
            // Class inhClass=null;
            //inhClass.getFields();

            constructorBody += "super(" + superArguments.substring(0, superArguments.length() - 1) + ");";
            for (MyField field : fields) {
                source.append(field.attType + " " + field.attName + ";\n\n");
                costructorArguments += field.attType + " " + field.attName + ",";
                constructorBody += "this." + field.attName + "=" + field.attName + ";\n\n";
            }
            constructorBody += "}\n\n";

            costructorArguments = costructorArguments.substring(0, costructorArguments.length() - 1);
            source.append(constructor);
            source.append(costructorArguments + ")\n\n");
            source.append(constructorBody + "\n\n");
            source.append(" public String toString() {\n\n").append("return \"\";").append(" }\n\n").append("@Override\n\n");
            //////////////  Begin of compare  //////////////////////////////////////////////////

            //////////////  Begin of compare  //////////////////////////////////////////////////
            source.append("public int compareTo(" + ClassLoader.getTheGrandParentName(parentClassLoader.getLoadedClass()) + " otherObj){\n\n");
            source.append(className + " other = (" + className + ") otherObj;\n\n");
            source.append("if(this.equals(other))return 0;\n\n");
            String s1 = "";
            for (MyField field : fields) {
                if (field.isCompared) {
                    if (!TypeRepository.getRepository().getType(field.attType).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.attType) instanceof Comparable) {
                        s1 = s1 + field.attName + ".compareTo(other." + field.attName + ")+";
                    } else {
                        s1 = s1 + "toInteger(" + field.attName + "<other." + field.attName + ")+";
                    }
                }
            }
            s1 = s1.substring(0, s1.length() - 1);
            source.append("return " + s1 + ";");
            source.append("}\n\n");
            source.append("@Override\n\n");
            source.append("public boolean equals(Object otherObj){\n\n");
            source.append(className + " other=(" + className + ")otherObj; \n\n");
            source.append("if(this==otherObj){\n\n");
            source.append("return true;\n\n");
            source.append("}\n\n");
            source.append("if(otherObj==null){\n\n");
            source.append("return false;\n\n");
            source.append("}\n\n");
            source.append("if(this.getClass()!=otherObj.getClass())\n\n return false; \n\n");
            String s = "";
            for (MyField field : fields) {
                if (field.isCompared) {
                    if (!TypeRepository.getRepository().getType(field.attType).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.attType) instanceof Comparable) {
                        s = s + field.attName + ".equals(other." + field.attName + ") &&";
                    } else {
                        s = s + field.attName + "==other." + field.attName + " &&";
                    }
                }
            }
            s = s.substring(0, s.length() - 3);
            source.append("return " + s + ";\n\n");
            source.append("}\n\n");
            ////////////////////////////////////////////////////////////////////////

        } else {
            source.append("public class " + className + " implements Comparable<" + className + ">{\n\n"); // badna nzeed extends lal class in choiceBox
            //*************//
            for (MyField field : fields) {
                source.append(field.attType + " " + field.attName + ";\n\n");
                costructorArguments += field.attType + " " + field.attName + ",";
                constructorBody += "this." + field.attName + "=" + field.attName + ";\n\n";
            }
            constructorBody += "}\n\n";
            costructorArguments = costructorArguments.substring(0, costructorArguments.length() - 1);
            source.append(constructor);
            source.append(costructorArguments + ")\n\n");

            source.append(constructorBody + "\n\n");

            source.append(" public String toString() {\n\n")
                    .append("return \"\";")
                    .append(" }\n\n")
                    .append("@Override\n\n");
            //////////////  Begin og compare  //////////////////////////////////////////////////

            //////////////  Begin og compare  //////////////////////////////////////////////////
            source.append("public int compareTo(" + className + " otherObj){\n\n");
            source.append("if(this.equals(otherObj))return 0;\n\n");
            String s1 = "";
            for (MyField field : fields) {
                if (field.isCompared) {
                    if (!TypeRepository.getRepository().getType(field.attType).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.attType) instanceof Comparable) {
                        s1 = s1 + field.attName + ".compareTo(otherObj." + field.attName + ")+";
                    } else {
                        s1 = s1 + "toInteger(" + field.attName + "<otherObj." + field.attName + ")+";
                    }
                }
            }
            s1 = s1.substring(0, s1.length() - 1);
            source.append("return " + s1 + ";");
            source.append("}\n\n");
            source.append("@Override\n\n");
            source.append("public boolean equals(Object otherObj){\n\n");
            source.append(className + " other=(" + className + ")otherObj; \n\n");
            source.append("if(this==otherObj){\n\n");
            source.append("return true;\n\n");
            source.append("}\n\n");
            source.append("if(otherObj==null){\n\n");
            source.append("return false;\n\n");
            source.append("}\n\n");
            source.append("if(this.getClass()!=otherObj.getClass())\n\n return false; \n\n");
            String s = "";
            for (MyField field : fields) {
                if (field.isCompared) {
                    if (!TypeRepository.getRepository().getType(field.attType).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.attType) instanceof Comparable) {
                        s = s + field.attName + ".equals(other." + field.attName + ") &&";
                    } else {
                        s = s + field.attName + "==other." + field.attName + " &&";
                    }
                }
            }
            s = s.substring(0, s.length() - 3);
            source.append("return " + s + ";\n\n");
            source.append("}\n\n");

        }

        ////////////////////////////////////////////////////////////////////////
        source.append("public int toInteger(boolean b){\n\n"
                + "if(b==true)return 1;\n\n"
                + "return 0;}\n\n");

        source.append("@Override\npublic int hashCode(){\n int hash=0;\n");
        String hash = "";
        for (MyField field : fields) {
            if (!TypeRepository.getRepository().getType(field.attType).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.attType) instanceof Comparable) {
                hash += hash + "hash=hash+this." + field.attName + ".hashCode();\n";
            } else {
                hash += hash + "hash=hash+this." + field.attName + ";\n";
            }
        }
        source.append(hash + "return hash;\n}\n\n");

        source.append("}\n\n");

        File file = new File(fullClassName + ".java");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(source.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        TypeRepository.getRepository().add(className, "NOT_PRIMITVE");

        // A byte array output stream containing the bytes that would be written to the .class file
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final SimpleJavaFileObject simpleJavaFileObject
                = new SimpleJavaFileObject(URI.create(fullClassName + ".java"), SOURCE) {
            @Override
            public CharSequence getCharContent(boolean ignoreEncodingErrors) {
                return "";
            }

            @Override
            public OutputStream openOutputStream() throws IOException {
                return byteArrayOutputStream;
            }
        };

    }

    public static final void main(String... args) throws ClassNotFoundException, URISyntaxException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        new JavaDynamicClassCreation().dynamicClassCreation();
    }

}
