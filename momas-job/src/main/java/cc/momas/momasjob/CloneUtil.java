package cc.momas.momasjob;

import java.io.*;

/**
 * @author Sod-Momas
 * @since 2022/11/13
 */
public class CloneUtil {
    public static Job deepCopy(Job serializable) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = null;
            out = new ObjectOutputStream(byteOut);
            out.writeObject(serializable);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            return (Job) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
