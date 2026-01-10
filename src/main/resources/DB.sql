-- Create tables

CREATE TABLE `dept` (
  `dept_no` bigint NOT NULL,
  `loc` varchar(255) DEFAULT NULL,
  `dname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `employee` (
  `emp_id` bigint NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `hire_date` date DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `salary` decimal(38,2) DEFAULT NULL,
  `dept_no` bigint DEFAULT NULL,
  PRIMARY KEY (`emp_id`),
  KEY `FKg9t48ekd9aigtrn86xt8oadhu` (`dept_no`),
  CONSTRAINT `FKg9t48ekd9aigtrn86xt8oadhu` FOREIGN KEY (`dept_no`) REFERENCES `dept` (`dept_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `salary` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `allowances` int DEFAULT NULL,
  `basic` int DEFAULT NULL,
  `dept` bigint DEFAULT NULL,
  `desg` varchar(255) DEFAULT NULL,
  `ga` int DEFAULT NULL,
  `hra` int DEFAULT NULL,
  `lta` int DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `pf` int DEFAULT NULL,
  `sa` int DEFAULT NULL,
  `salmonth` varchar(255) DEFAULT NULL,
  `emp_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK52i6nbheu51kqc7bfslc4wo7i` (`emp_id`),
  CONSTRAINT `FK52i6nbheu51kqc7bfslc4wo7i` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `payslip` (
  `emp_id` bigint NOT NULL,
  `salmonth` varchar(255) NOT NULL,
  `allowances` int DEFAULT NULL,
  `basic` int DEFAULT NULL,
  `dept` int DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `ename` varchar(255) DEFAULT NULL,
  `ga` int DEFAULT NULL,
  `hra` int DEFAULT NULL,
  `it` int DEFAULT NULL,
  `lta` int DEFAULT NULL,
  `pan` varchar(255) DEFAULT NULL,
  `pf` int DEFAULT NULL,
  `pfno` varchar(255) DEFAULT NULL,
  `proftax` int DEFAULT NULL,
  `sa` int DEFAULT NULL,
  `workdays` int DEFAULT NULL,
  PRIMARY KEY (`emp_id`,`salmonth`),
  CONSTRAINT `FK49pf3ei6i8gpyhy2hrb7vljgb` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Stored Procedure
DELIMITER $$

CREATE PROCEDURE insert_payslip_for_month (IN p_emp_id BIGINT, IN p_salmonth VARCHAR(20), IN p_workdays INT
)
BEGIN
    -- Employee details
    DECLARE v_first_name VARCHAR(255);
    DECLARE v_last_name VARCHAR(255);
    DECLARE v_dept_no BIGINT;

    -- Salary details
    DECLARE v_basic INT;
    DECLARE v_allowances INT;
    DECLARE v_hra INT;
    DECLARE v_lta INT;
    DECLARE v_pf INT;
    DECLARE v_ga INT;
    DECLARE v_sa INT;
    DECLARE v_pan VARCHAR(10);
    DECLARE v_desg VARCHAR(25);

    -- Deductions
    DECLARE v_it INT;
    DECLARE v_proftax INT;

    IF NOT EXISTS (
        SELECT 1 FROM employee WHERE emp_id = p_emp_id
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Employee does not exist';
    END IF;

    IF NOT EXISTS (
        SELECT 1 FROM salary
        WHERE emp_id = p_emp_id
          AND salmonth = p_salmonth
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Salary not found for selected month';
    END IF;

    /* 3️⃣ Prevent duplicate payslip */
    IF EXISTS (
        SELECT 1 FROM payslip
        WHERE emp_id = p_emp_id
          AND salmonth = p_salmonth
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Payslip already generated for this employee and month';
    END IF;

    /* 4️⃣ Fetch employee details */
    SELECT first_name, last_name, dept_no
    INTO v_first_name, v_last_name, v_dept_no
    FROM employee
    WHERE emp_id = p_emp_id;

    /* 5️⃣ Validate department */
    IF NOT EXISTS (
        SELECT 1 FROM dept WHERE dept_no = v_dept_no
    ) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Invalid department';
    END IF;

    /* 6️⃣ Fetch salary details */
    SELECT basic, allowances, hra, lta, pf, ga, sa, pan, desg 
    INTO v_basic, v_allowances, v_hra, v_lta,
         v_pf, v_ga, v_sa, v_pan, v_desg
    FROM salary
    WHERE emp_id = p_emp_id
      AND salmonth = p_salmonth;

    /* 7️⃣ Calculate deductions (sample logic) */
    SET v_it = ROUND((v_basic + v_allowances) * 0.10);  -- 10% IT
    SET v_proftax = 200;                               -- Flat PT

    /* 8️⃣ Insert payslip */
    INSERT INTO payslip (
        salmonth,
        ename,
        description,
        emp_id,
        dept,
        pan,
        pfno,
        workdays,
        basic,
        allowances,
        hra,
        lta,
        pf,
        ga,
        sa,
        it,
        proftax
    )
    VALUES (
        p_salmonth,
        CONCAT(v_first_name, ' ', v_last_name),
        v_desg,
        p_emp_id,
        v_dept_no,
        v_pan,
        CONCAT('PF-', p_emp_id),
        p_workdays,
        v_basic,
        v_allowances,
        v_hra,
        v_lta,
        v_pf,
        v_ga,
        v_sa,
        v_it,
        v_proftax
    );

END$$

DELIMITER ;

-- second stored procedure
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_full_name`(
    IN p_first_name VARCHAR(100),
    IN p_last_name  VARCHAR(100),
    OUT p_full_name VARCHAR(255)
)
BEGIN
    SET p_full_name = CONCAT(p_first_name, ' ', p_last_name);
END$$
DELIMITER ;