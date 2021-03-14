package sst.club.members.file;

import sst.club.members.model.Member;

import java.io.IOException;
import java.util.List;

public interface SaveAndLoad {
    void setCollection(List<Member> list);
    List<Member> getCollection();
    void exportData(String filename) throws IOException;
    void importData(String filename) throws IOException;
}
