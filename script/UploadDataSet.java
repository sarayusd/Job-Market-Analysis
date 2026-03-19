import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.IOException;
import java.net.URI;


public class UploadDataSet {
    public static void main(String[] args) {
        String hdfsUri = "hdfs://namenode:8020";
        String[] localFiles = {
            "/tmp/datasets/job_skills.csv",
            "/tmp/datasets/linkedin_job_postings.csv",
            "/tmp/datasets/job_summary.csv"
        };
        String hdfsDestination = "/user/hadoop/csv_files/";

        Configuration conf = new Configuration();
        conf.set("fs.defaultFS", hdfsUri);
        
        try {
            FileSystem fs = FileSystem.get(new URI(hdfsUri), conf);

            Path hdfsDir = new Path(hdfsDestination);
            if (!fs.exists(hdfsDir)) {
                fs.mkdirs(hdfsDir);
            }

            for (String localFile : localFiles) {
                Path srcPath = new Path(localFile);
                Path destPath = new Path(hdfsDestination + srcPath.getName());
                
                fs.copyFromLocalFile(srcPath, destPath);
                System.out.println("Uploaded: " + localFile + " to " + destPath);
            }
            System.out.println("Files in HDFS Directory: " );
            FileStatus[] fileStatuses = fs.listStatus(hdfsDir);
            for (FileStatus fileStatus : fileStatuses) {
                Path filePath = fileStatus.getPath();
                System.out.println(filePath);
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
