package top.qxfly.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalFile {
    private String fileRealName;
    private String fileMd5Name;
    private String filePath;


}
