package kodlamaio.hmrs.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;

import kodlamaio.hmrs.entities.concretes.JobAdvertisement;
import kodlamaio.hmrs.entities.concretes.dtos.JobAdvertisementWithEmployerDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getAllIsActive();
	DataResult<List<JobAdvertisement>> getAllSorted();
	DataResult<List<JobAdvertisement>> getAllByOrderByCreatedAt();
	DataResult<List<JobAdvertisement>> getAllIsActiveByUserId(int id);
	DataResult<List<JobAdvertisementWithEmployerDto>> getAllIsActiveDto();
}
