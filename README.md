# LinkedIn Job Market Analysis – Big Data Pipeline

An end-to-end big data pipeline to analyze ~1.3M LinkedIn job postings and uncover trends in job roles, skill demand, and hiring patterns using PySpark on HDFS.

---

## Tech Stack

Python · PySpark · Spark MLlib · Hadoop (HDFS) · Java · Docker · Docker Compose · Bash

---

## Pipeline

Docker Cluster Setup → Dataset Ingestion via Java HDFS Client → HDFS Storage → PySpark Processing → Data Cleaning → Feature Engineering → ML Models → Evaluation → Model Persistence

---

## Infrastructure & Data Ingestion

- Provisioned a local **multi-container Hadoop cluster** using **Docker Compose** with a running NameNode verified before execution
- Wrote a **Java Hadoop client** (`UploadDataSet.java`) using the Hadoop FileSystem API to upload raw CSV datasets (`job_skills.csv`, `linkedin_job_postings.csv`, `job_summary.csv`) directly into HDFS at `/user/hadoop/csv_files/`
- Automated cluster startup and dataset ingestion via a **bash script** (`script.sh`) that handles container orchestration, file transfer into the namenode container, and Hadoop health checks before execution

---

## Data Cleaning & Processing

- Handled missing values in key fields (job_title, job_skills, job_summary)
- Standardized job titles and skill formats
- Transformed unstructured skills into structured format via split and tokenization
- Removed duplicates and invalid entries
- Performed data type conversions for categorical features

---

## Machine Learning

- **Job Title Prediction** — TF-IDF + Random Forest classification; cross-validated with F1 scoring 
- **Internship vs Full-Time Classification** — Logistic Regression on engineered features (skill count, summary length); cross-validated with AUC evaluation
- **Skill-Based Job Clustering** — K-Means clustering with Silhouette-based tuning and PCA visualization for skill grouping

---

## Evaluation

- Cross-validation with ParamGridBuilder across num trees, max depth, regularization parameters
- Metrics: Accuracy, F1, Precision, Recall, AUC
- Trained models and predictions persisted to HDFS for reproducible experimentation

---

## Scalability

- HDFS for distributed storage across the full 1.3M record dataset
- PySpark for large-scale ingestion, transformation, and model training
- Spark configurations tuned for memory, parallelism, and shuffle partitions

---

## Setup & Running

```bash
# Start Hadoop cluster and ingest datasets
bash script.sh
```

Requires Docker and Docker Compose. Place datasets in:
`~/Documents/DataIntensiveComputing/project/job_postings/datasets`
before running.

---

## Project Structure

```
├── script.sh                  # Cluster startup and dataset ingestion automation
├── UploadDataSet.java          # Java Hadoop client for HDFS upload
├── ml_1_job_title_prediction.ipynb
├── ml_2_group_by_skill_demand.ipynb
├── ml_3_predict_intern.ipynb
├── cse_587_phase2_task1.ipynb
└── cse_587_phase2_task2.ipynb
```
