package edu.cs4624.idealspreadsheet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.cs4624.idealspreadsheet.data.WordcountMap;

@Controller
public class WordcountController {
	
	private final static String HDFS_DIR = "hdfs://localhost/user/cloudera";

	@RequestMapping(value="/wordcount", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Integer> wordcount(HttpServletRequest request, Model m) {
		String id = request.getParameter("id");
		WordcountMap map = new WordcountMap();
		
		/** Set the configuration with the default HDFS directory */
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", HDFS_DIR);
		
		/** Create the job. */
		try {
			Job job = new Job(conf);
			FileSystem fs = DistributedFileSystem.get(conf);
			System.out.println(fs.getWorkingDirectory());
			
			job.setMapperClass(edu.cs4624.idealspreadsheet.wordcount.Map.class);
			job.setReducerClass(edu.cs4624.idealspreadsheet.wordcount.Reduce.class);
			job.setJarByClass(edu.cs4624.idealspreadsheet.wordcount.Map.class);
			
			job.setOutputKeyClass(Text.class);
			job.setOutputValueClass(IntWritable.class);
			
			job.setInputFormatClass(TextInputFormat.class);
			job.setOutputFormatClass(TextOutputFormat.class);
			
			FileInputFormat.addInputPath(job, new Path(HDFS_DIR + "/wordcount/" + id));
			Path output = new Path(HDFS_DIR + "/wordcount/" + id + "_out");
			fs.delete(output, true);
			FileOutputFormat.setOutputPath(job, output);
			
			job.waitForCompletion(true);
			
			Path results = new Path(HDFS_DIR + "/wordcount/" + id + "_out/part-r-00000");
			BufferedReader b = new BufferedReader(new InputStreamReader(fs.open(results)));
			String line;
			while ((line = b.readLine()) != null) {
				map.addEntry(line.split("\t")[0], Integer.valueOf(line.split("\t")[1]));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map.getMapping();
	}
}
