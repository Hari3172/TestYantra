
package com.ty.hrms.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class LeaveRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer leaveRequestId;
	private String employeeId;
	private LocalDate leaveRequestStartDate;
	private LocalDate leaveRequestEndDate;
	private String leaveRequestLeaveType;
	private String leaveRequestStatus; // Status(Pending/Approved/Rejected)
	private String leaveRequestReason;
}
