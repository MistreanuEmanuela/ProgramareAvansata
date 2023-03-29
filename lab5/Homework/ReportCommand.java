package org.example;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ReportCommand extends Command {
    private static Catalog c;

    ReportCommand(Catalog c) {
        if(c.getDoc().size() == 0){
            try {
                throw new InvalidCatalog();
            } catch (InvalidCatalog e) {
                throw new RuntimeException(e);
            }
        }
        this.c = c;
    }

    @Override
    public void execute() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            cfg.setDirectoryForTemplateLoading(new File("C:\\E\\run"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            //Create Data Model
            Map<String, Object> map = new HashMap<>();
            map.put("blogTitle", "Freemarker Template Demo");
            map.put("message", "Getting started with Freemarker.<br/>Find a simple Freemarker demo.");
            List<Document> references = new ArrayList<>();
            references.addAll(c.getDoc());
            //   references.add(new Document("Java"));
            //   references.add(new Document("poo"));
            //   references.add(new Document("Ag"));
            map.put("references", references);
            Template template = cfg.getTemplate("Report.ftl");
            Writer console = new OutputStreamWriter(System.out);
            template.process(map, console);
            console.flush();
            Writer file = new FileWriter(new File("C:\\E\\run\\Report"));
            template.process(map, file);
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        Document d = new Document("Report");
        d.setPath("C:\\E\\run\\Report.html");
        ViewCommand view = new ViewCommand(d);
        view.execute();
    }
}


