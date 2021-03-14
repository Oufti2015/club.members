package sst.club.members.file;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import lombok.extern.log4j.Log4j2;
import sst.club.members.model.Member;
import sst.common.file.output.OutputFile;
import sst.textfile.InputTextFile;
import sst.textfile.InputTextFileImpl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class JsonInterface implements SaveAndLoad {
    private List<Member> list = new ArrayList<>();

    @Override
    public void setCollection(List<Member> list) {
        this.list = list;
    }

    @Override
    public List<Member> getCollection() {
        return list;
    }

    @Override
    public void exportData(String fileName) throws IOException {
        final File file = new File(fileName);
        try (OutputFile outputFile = new OutputFile(file)) {
            // Object to JSON in outputFile
            outputFile.println(getGson().toJson(list));
        } catch (IOException e) {
            log.fatal("Cannot save " + fileName, e);
        }
        log.info(list.size() + " Members written to file");
        log.info(file.getAbsolutePath());
    }

    private Gson getGson() {
        return new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public void importData(String filename) throws IOException {
        Type listType = new TypeToken<ArrayList<Member>>() {
        }.getType();

        // JSON from file to Object
        try {
            InputTextFile textFile = new InputTextFileImpl(new File(filename));
            list = getGson().fromJson(textFile.oneLine(), listType);
        } catch (IOException e) {
            log.fatal("Cannot read file " + filename, e);
        }
    }
}
