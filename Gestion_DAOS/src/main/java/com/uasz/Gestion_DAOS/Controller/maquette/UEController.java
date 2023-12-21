package com.uasz.Gestion_DAOS.Controller.maquette;

import com.uasz.Gestion_DAOS.Service.maquette.UEService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myapi/ues")
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class UEController {
    @Autowired
    private UEService ueService;
}
