package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Class Entry service.
 */
@Service
public class EntryService {
    private EntryRepository entryRepository;

    /**
     * Instantiates a new Entry service.
     *
     * @param entryRepository the entry repository
     */
    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    /**
     * Create entry.
     *
     * @param entry the entry
     * @return the entry
     */
    public Entry createEntry(Entry entry) {
        return entryRepository.saveAndFlush(entry);
    }

    /**
     * Find all entries as a list.
     *
     * @return the list of entries
     */
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    /**
     * Delete entry by id.
     *
     * @param id the id
     */
    public void deleteEntry(long id) { entryRepository.deleteById(id); }

    /**
     * Update entry.
     *
     * Change attributes of entry
     *
     * @param entry the entry
     * @return the entry
     */
    public Entry updateEntry(Entry entry) {
        return entryRepository.save(entry);
    }
}
