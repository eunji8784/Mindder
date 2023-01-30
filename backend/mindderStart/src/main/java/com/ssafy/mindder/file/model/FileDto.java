package com.ssafy.mindder.file.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileDto {
	private int fileIdx;
	private String saveFolder;
	private String originalFile;
	private String saveFile;
}
