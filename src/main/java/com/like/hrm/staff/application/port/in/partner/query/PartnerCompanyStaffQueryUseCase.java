package com.like.hrm.staff.application.port.in.partner.query;

import java.util.List;

public interface PartnerCompanyStaffQueryUseCase {
    List<PartnerCompanyStaffQueryResultDTO> query(PartnerCompanyStaffQueryDTO dto);
}
