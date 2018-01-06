package dictionary_master;

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
import org.omg.CORBA.Environment;

/**
 * by Rob Austin date Feb 1013
 */
public class JavaDynamicClassCreation {

    private String className;
    private ArrayList<MyField> fields;

    public JavaDynamicClassCreation() {
        this.className = "Hello";
        this.fields = new ArrayList();
    }

    public JavaDynamicClassCreation(String className, ArrayList<MyField> fields) {
        System.out.println("class created "+className);
        this.className = className;
        this.fields = fields;
    }

    public void dynamicClassCreation() throws ClassNotFoundException, IllegalAccessException, InstantiationException, URISyntaxException, NoSuchFieldException {
        final String path = "./src/dictionary_master";
        System.out.println(path);
        final String fullClassName = path + "/" + className;

         StringBuilder source = new StringBuilder();
        source.append("package dictionary_master;\n");
       //**************//
        source.append("public class " + className + " implements Comparable<" + className + ">{\n"); // badna nzeed extends lal class in choiceBox
        //*************//
        for (MyField field : fields) {
            source.append(field.type + " " + field.name + ";\n");

        }
        
        //*************//
        source.append(" public String toString() {\n")
                .append("return \"HelloWorld - Java Dynamic Class Creation was written by Rob Austin\";")
                .append(" }\n")
                .append("@Override\n");

        //////////////Begin og compare//////////////////////////////////////////////////
        //////Begin og compare//////////////////////////////////////////////////
        source.append("public int compareTo("+className+" otherObj){\n");
            
            source.append("if(this.equals(otherObj))return 0;\n");
            String s1="";
        for(MyField field:fields){
        	
        	if(field.isCompared){
        	   if(!TypeRepository.getRepository().getType(field.type).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.type) instanceof Comparable){
        		   s1=s1+field.name+".compareTo(otherObj."+field.name+")+";
        	   }
        	   else{
                           
                           s1=s1+"toInteger("+field.name+"<otherObj."+field.name+")+";                       
        	   }
        	}

        	
        }
        
       s1=s1.substring(0,s1.length()-1);
       
       source.append("return "+s1+";");
        source.append("}\n");
        
        
      source.append("@Override\n");
        
        source.append("public boolean equals(Object otherObj){\n");
       source.append(className+" other=("+className+")otherObj; \n");
         source.append("if(this==otherObj){\n");
                source.append("return true;\n");
                source.append("}\n");
                
                source.append("if(otherObj==null){\n");
                source.append("return false;\n");
                source.append("}\n");
                
                
                source.append("if(this.getClass()!=otherObj.getClass())\n return false; \n");
                
                
        String s="";
        for(MyField field:fields){
        	
                
        	if(field.isCompared){
                    
                    
        	   if(!TypeRepository.getRepository().getType(field.type).equals(TypeRepository.PRIMITIVE) && TypeRepository.getRepository().getType(field.type) instanceof Comparable){
        		   s=s+field.name+".equals(other."+field.name+") &&";
        	   }
        	   else{
         		   s=s+field.name+"==other."+field.name+" &&";
        	   }
        	}
                
                
        	
        }
        s=s.substring(0,s.length()-3);
        
        source.append("return "+s+";\n");
        source.append("}\n");
        ////////////////////////////////////////////////////////////////////////

        
        source.append("public int toInteger(boolean b){\n"
                + "if(b==true)return 1;\n"
                + "return 0;}\n");
        source.append("}\n");

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
//        @SuppressWarnings("unchecked")
//		final JavaFileManager javaFileManager = new ForwardingJavaFileManager(
//                ToolProvider.getSystemJavaCompiler().getStandardFileManager(null, null, null)) {
//
//            @Override
//            public JavaFileObject getJavaFileForOutput(Location location,
//                                                       String className,
//                                                       JavaFileObject.Kind kind,
//                                                       FileObject sibling) throws IOException {
//                return simpleJavaFileObject;
//            }
//        };
//
//        ToolProvider.getSystemJavaCompiler().getTask(
//                null, javaFileManager, null, null, null, singletonList(simpleJavaFileObject)).call();
//
//        final byte[] bytes = byteArrayOutputStream.toByteArray();
//
//        // use the unsafe class to load in the class bytes
//        final Field f = Unsafe.class.getDeclaredField("theUnsafe");
//        f.setAccessible(true);
//        final Unsafe unsafe = (Unsafe) f.get(null);
//        Class cl=Class.forName(className);
//        ClassLoader CLASS_LOADER =cl.getClassLoader();
//        ProtectionDomain d=cl.getProtectionDomain();
//        final Class aClass = unsafe.defineClass(fullClassName, bytes, 0, bytes.length,new ClassLoader(CLASS_LOADER) {
//            @Override
//            protected Class<?> findClass(String name) throws ClassNotFoundException {
//                byte[] code =bytes;
//                if(code == null) throw new ClassNotFoundException(name);
//                return defineClass(name, code, 0, code.length);
//            }
//        },d);
//
//        final Object o = aClass.newInstance();
//        System.out.println(o);

    }

    public static final void main(String... args) throws ClassNotFoundException, URISyntaxException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        new JavaDynamicClassCreation().dynamicClassCreation();
    }

}
