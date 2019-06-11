package com.project.deadofwinter.business;

import org.springframework.stereotype.Service;

import com.project.deadofwinter.model.MainObjective;

@Service
public interface SearchService {

	public MainObjective search(boolean isOriginal, boolean isExtension, boolean isCustom);

}
