
# LinkedIn Job Market Analysis – Big Data Pipeline

Built an end-to-end big data pipeline to analyze large-scale LinkedIn job postings (~1.3M records) and uncover trends in job roles, skill demand, and hiring patterns.

---

##  Tech Stack
Python (Pandas, NumPy) · PySpark · Spark MLlib · Hadoop (HDFS) · SQL · Docker

---

## Pipeline
Data Ingestion → HDFS Storage → PySpark Processing → Data Cleaning → Feature Engineering → ML Models → Visualization → Insights

---

## Data Cleaning & Processing
- Handled missing values in key fields (job_title, job_skills, location)  
- Standardized inconsistent job titles and locations  
- Transformed unstructured skills into structured format (split + explode)  
- Removed duplicates and invalid entries (e.g., “Unknown”)  
- Performed data type conversions for timestamps and categorical features  

---

## Machine Learning
- Job Title Prediction (Classification using TF-IDF + Random Forest)  
- Salary Prediction (Regression based on job features)  
- Job Clustering (Skill-based grouping using TF-IDF / Word2Vec)  

---

## Analysis & Insights
- Identified top job roles across locations  
- Extracted most in-demand skills by job category  
- Analyzed company hiring trends  
- Mapped job roles to required skills  


---

## Visualization
- Bar charts (job titles, companies, locations)  
- Heatmaps (regional trends)  
- Word clouds (skill demand)  

---

## Scalability
- Used HDFS for distributed storage  
- Leveraged PySpark for large-scale data processing  
- Tuned Spark configurations for performance  

---
