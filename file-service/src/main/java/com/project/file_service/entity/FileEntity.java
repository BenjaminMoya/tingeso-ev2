package com.project.file_service.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long fileId;

    private Long creditId;
    private String filename;

    // 1=CI,2=CA,3=HC,4=EPV,5=EFN,6=PDN,7=PR,8=CAA,9=Contrato
    private int type;

    @Lob
    private byte[] fileContent;
}
