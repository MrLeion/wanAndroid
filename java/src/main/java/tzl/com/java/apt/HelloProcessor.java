//package tzl.com.java.apt;
//
//import com.google.auto.service.AutoService;
//import com.squareup.javapoet.JavaFile;
//import com.squareup.javapoet.MethodSpec;
//import com.squareup.javapoet.TypeSpec;
//
//import junit.framework.Test;
//
//import java.io.IOException;
//import java.lang.reflect.Modifier;
//import java.util.Collections;
//import java.util.Set;
//
///**
// * author: tangzenglei
// * created on: 2018/9/6 下午5:27
// * description:
// */
//
//@AutoService(Processor.class)
//public class HelloProcessor extends AbstractProcessor {
//
//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        return Collections.singleton(Test.class.getCanonicalName());
//    }
//    @Override
//    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//        MethodSpec main = MethodSpec.methodBuilder("main")
//                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//                .returns(void.class)
//                .addParameter(String[].class, "args")
//                .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//                .build();
//        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
//                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//                .addMethod(main)
//                .build();
//        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
//                .build();
//        try {
//            javaFile.writeTo(processingEnv.getFiler());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//}
