package classload.namecheck;


import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.lang.reflect.Method;

public class NameChecker {

    private final Messager messager;

    NameCheckScanner nameCheckScanner = new NameCheckScanner();

    public NameChecker(ProcessingEnvironment processingEnv){
        messager = processingEnv.getMessager();
    }

    public void checkNames(Element element){
        nameCheckScanner.scan(element);
    }

    private class NameCheckScanner extends ElementScanner8<Void, Void> {

        @Override
        public Void visitType(TypeElement e, Void aVoid) {
            scan(e.getTypeParameters(),aVoid);
            checkCamelCase(e, true);
            super.visitType(e, aVoid);
            return null;
        }

        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {
            if (e.getKind() == ElementKind.METHOD) {
                Name name = e.getSimpleName();
                if (name.contentEquals(e.getEnclosingElement().getSimpleName())) {
                    messager.printMessage(Diagnostic.Kind.WARNING,"");
                }
                checkCamelCase(e, false);
            }
            super.visitExecutable(e, aVoid);
            return null;
        }

        private void checkCamelCase(Element e, boolean b) {
        }
    }
}
